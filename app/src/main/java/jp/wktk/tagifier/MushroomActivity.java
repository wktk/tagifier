package jp.wktk.tagifier;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.ClipboardManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MushroomActivity extends Activity {

    private static final String ACTION_SEND = "android.intent.action.SEND";
    private static final String ACTION_SIMEJI_INTERCEPT = "com.adamrocker.android.simeji.ACTION_INTERCEPT";
    private static final String ACTION_TWICCA_EDIT_TWEET = "jp.r246.twicca.ACTION_EDIT_TWEET";
    private static final String KEY_EXTRA_TEXT = "android.intent.extra.TEXT";
    private static final String KEY_SIMEJI_REPLACE = "replace_key";
    private static final Integer MODE_EDIT_TWEET = 2;
    private static final Integer MODE_MUSHROOM = 1;
    private static final Integer MODE_NORMAL = 0;
    private static final Pattern NON_HASHTAG_START_AND_END = Pattern.compile(
            "^[^" + Regex.HASHTAG_CHARS + "]+|[^" + Regex.HASHTAG_CHARS + "]+$", Pattern.CASE_INSENSITIVE);
    private static final Pattern NON_HASHTAG = Pattern.compile("[^" + Regex.HASHTAG_CHARS + "]+", Pattern.CASE_INSENSITIVE);

    private Integer mode = MODE_NORMAL;
    private EditText editText;

    private String convert(String string){
        Matcher startAndEnd = NON_HASHTAG_START_AND_END.matcher(string);
        Matcher textBody = NON_HASHTAG.matcher(startAndEnd.replaceAll(""));
        return "#" + textBody.replaceAll("_");
    }

    private void initialize() {
        String originalText = null;
        Intent intent = getIntent();
        String action = intent.getAction();

        // Shared with
        if (ACTION_SEND.equals(action)) {
            Bundle extras = intent.getExtras();
            if (extras != null) {
                CharSequence ext = extras.getCharSequence(Intent.EXTRA_TEXT);
                originalText = ext.toString();
            }
        }

        // Called from Simeji
        else if (ACTION_SIMEJI_INTERCEPT.equals(action)) {
            mode = MODE_MUSHROOM;
            originalText = intent.getStringExtra(KEY_SIMEJI_REPLACE);
        }

        // Called as twicca plugin
        else if (ACTION_TWICCA_EDIT_TWEET.equals(action)){
            mode = MODE_EDIT_TWEET;
            originalText = intent.getStringExtra(KEY_EXTRA_TEXT);
        }

        // Load from clipboard unless originalText has been defined
        if (originalText == null || originalText.equals("")) {
            @SuppressWarnings("deprecation")
            ClipboardManager clip = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
            CharSequence clipText = clip.getText();
            if (clipText != null) {
                originalText = clipText.toString();
            } else {
                originalText = "";
            }
        }

        // Paste the original text on EditText
        editText.setText(originalText, TextView.BufferType.NORMAL);
        editText.selectAll();
    }

    private void onClickConvert(View view) {
        String text = editText.getText().toString();
        String result = convert(text);

        if (mode.equals(MODE_MUSHROOM)) {
            returnResult(KEY_SIMEJI_REPLACE, result);
        } else if (mode.equals(MODE_EDIT_TWEET)) {
            returnResult(KEY_EXTRA_TEXT, result);
        } else {
            editText.setText(result, TextView.BufferType.NORMAL);
            editText.selectAll();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mushroom);
        getWindow().setLayout(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        editText = (EditText) findViewById(R.id.edit_text);

        initialize();

        // Listen on the button
        Button buttonConvert = (Button) findViewById(R.id.button_convert);
        buttonConvert.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) { onClickConvert(view); }
        });
    }

    private void returnResult(String extraKey, String result) {
        Intent intent = new Intent();
        intent.putExtra(extraKey, result);
        setResult(RESULT_OK, intent);
        finish();
    }
}
