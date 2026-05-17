SUMMARY = "SQL helper library from Babelouest"
DESCRIPTION = "Hoel is a lightweight database abstraction layer used by Ulfius."
HOMEPAGE = "https://github.com/babelouest/hoel"

LICENSE = "LGPL-2.1-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=40d2542b8c43a3ec2b7f5da31a697b88"

SRC_URI = "git://github.com/babelouest/hoel.git;protocol=https;branch=master"

SRCREV = "33598d2c8defc4eeff208249b5bed67c7ed62e48"

PV = "1.4.29+git${SRCPV}"

S = "${WORKDIR}/git"

inherit cmake pkgconfig

DEPENDS = "\
    sqlite3 \
    jansson \
    liborcania \
    libyder \
"

EXTRA_OECMAKE = "\
    -DWITH_MARIADB=OFF \
    -DWITH_PGSQL=OFF \
    -DBUILD_HOEL_TESTING=OFF \
    -DBUILD_SHARED_LIBS=ON \
"

FILES:${PN} += "\
    ${libdir}/libhoel*.so.* \
"

FILES:${PN}-dev += "\
    ${includedir}/hoel.h \
    ${libdir}/libhoel.so \
    ${libdir}/pkgconfig/*.pc \
    ${libdir}/cmake/Hoel/* \
"
