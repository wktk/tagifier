/*
 * Copyright 2011 Twitter, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this work except in compliance with the License.
 * You may obtain a copy of the License below, or at:
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package jp.wktk.tagifier;

public class Regex {

    private static final String HASHTAG_LETTERS = "\\p{L}\\p{M}";
    private static final String HASHTAG_NUMERALS = "\\p{Nd}";
    private static final String HASHTAG_SPECIAL_CHARS = "_" + //underscore
            "\\u200c" + // ZERO WIDTH NON-JOINER (ZWNJ)
            "\\ua67e" + // CYRILLIC KAVYKA
            "\\u05be" + // HEBREW PUNCTUATION MAQAF
            "\\u05f3" + // HEBREW PUNCTUATION GERESH
            "\\u05f4" + // HEBREW PUNCTUATION GERSHAYIM
            "\\u309b" + // KATAKANA-HIRAGANA VOICED SOUND MARK
            "\\u309c" + // KATAKANA-HIRAGANA SEMI-VOICED SOUND MARK
            "\\u30a0" + // KATAKANA-HIRAGANA DOUBLE HYPHEN
            "\\u30fb" + // KATAKANA MIDDLE DOT
            "\\u3003" + // DITTO MARK
            "\\u0f0b" + // TIBETAN MARK INTERSYLLABIC TSHEG
            "\\u0f0c" + // TIBETAN MARK DELIMITER TSHEG BSTAR
            "\\u0f0d";  // TIBETAN MARK SHAD
    public static final String HASHTAG_CHARS = HASHTAG_LETTERS + HASHTAG_NUMERALS + HASHTAG_SPECIAL_CHARS;

}
