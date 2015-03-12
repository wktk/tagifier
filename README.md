# Tagifer

Android app that converts texts into a Twitter hashtag

[![Get it on Google Play][get-it-logo]][app-on-google-play]

[app-on-google-play]: https://play.google.com/store/apps/details?id=jp.wktk.tagifier
[get-it-logo]: https://developer.android.com/images/brand/en_generic_rgb_wo_45.png

## Features

- Works as a [Mushroom](http://simeji.me/blog/make_mushroom)
- Compatible with [twicca plugin (tweet editor)](http://twicca.r246.jp/developers/edit_tweet_action/)
- Supports share intents

## Versioning

This software aims to adhere to [Semantic Versioning 2.0.0][semver]. Violations
of this scheme should be reported as bugs.  Specifically, if a minor or patch
version is released that breaks backward compatibility, that version should be
immediately yanked and/or a new version should be immediately released that
restores compatibility.  Breaking changes to the public API will only be
introduced with new major versions.

[semver]: http://semver.org/

## License

### Tagifer

```
Copyright (C) 2015 wktk <https://github.com/wktk>

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>.
```

See `LICENSE` for further details.

### twitter-text-java

`/app/src/main/java/jp/wktk/tagifier/Regex.java` is a Derivative Work
from `/src/com/twitter/Regex.java` in the [twitter-text-java] library.

[twitter-text-java]: https://github.com/twitter/twitter-text/tree/master/java

```
Copyright 2011 Twitter, Inc.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this work except in compliance with the License.
You may obtain a copy of the License below, or at:

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
