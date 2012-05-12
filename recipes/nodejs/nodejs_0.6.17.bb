DESCRIPTION = "nodeJS Evented I/O for V8 JavaScript"
HOMEPAGE = "http://nodejs.org"
LICENSE = "MIT"

DEPENDS = "openssl"

SRC_URI = " \
  http://nodejs.org/dist/v${PV}/node-v${PV}.tar.gz \
"

SRC_URI[md5sum] = "55641d5d280cdd4e0c030c203107599d"
SRC_URI[sha256sum] = "8dfe5948de27e37a14af184f06e7bd89a23c3b248af44c8ef5cffcd0e4c65778"

S = "${WORKDIR}/node-v${PV}"

# v8 errors out if you have set CCACHE
CCACHE = ""

# v8 wont build on less than armv5t
do_configure () {
  ./configure --prefix=${prefix} --without-snapshot
}

do_compile () {
  export CCFLAGS="-march=armv5te"
  make 
}

do_install () {
  DESTDIR=${D} oe_runmake install
}

BBCLASSEXTEND = "native"
