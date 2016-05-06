artemis-odb-contrib
===================

[![Build Status](https://travis-ci.org/gaconkzk/artemis-odb-contrib.svg)](https://travis-ci.org/gaconkzk/artemis-odb-contrib)

[![Download](https://api.bintray.com/packages/gaconkzk/maven/artemis-odb-contrib/images/download.svg) ](https://bintray.com/gaconkzk/maven/artemis-odb-contrib/_latestVersion)

Drop-in extensions for artemis-odb. Event bus, scheduled operations, deferred systems, profiler, abstract and prefab
systems, components and networking. Well, eventually anyway.

### When to use this
If you want to quickly prototype a game without getting bogged down by the
details of entity component systems, this package will help get you started.

I use this toolkit for jam games. You are welcome to use it for whatever you need!

Alternatively, if you want to properly set up artemis-odb + libgdx or playn 
with all fancy features, check out these instead:
- [libgdx-artemis-quickstart](https://github.com/DaanVanYperen/libgdx-artemis-quickstart)
- [playn-artemis-quickstart](https://github.com/DaanVanYperen/playn-artemis-quickstart)

### Library Versions
Artemis-odb 2.0.x, (Optional) LibGDX 1.9+, tested with 1.9.2

### License
The primary license for this code is MIT. 
Some stubs from LibGDX are licensed under Apache 2.0.

### Download

#### Maven

```xml
<dependency>
  <groupId>com.github.gaconkzk.artemis-odb-contrib</groupId>
  <artifactId>contrib-core</artifactId>
  <version>1.1.0</version>
</dependency>

<dependency>
  <groupId>com.github.gaconkzk.artemis-odb-contrib</groupId>
  <artifactId>contrib-eventbus</artifactId>
  <version>1.1.0</version>
</dependency>
```

#### Gradle

```groovy
dependencies { 
    compile "com.github.gaconkzk.artemis-odb-contrib:contrib-core:1.1.0"
    compile "com.github.gaconkzk.artemis-odb-contrib:contrib-eventbus:1.1.0"
}
```
