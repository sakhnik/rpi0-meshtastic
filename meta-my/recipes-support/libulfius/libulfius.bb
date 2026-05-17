SUMMARY = "Web framework for REST APIs and HTTP services"
DESCRIPTION = "Ulfius is a framework to build REST APIs, webservices or HTTP clients."
HOMEPAGE = "https://github.com/babelouest/ulfius"
LICENSE = "LGPL-2.1-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=40d2542b8c43a3ec2b7f5da31a697b88"

SRC_URI = "git://github.com/babelouest/ulfius.git;branch=master;protocol=https"
SRCREV = "a0603447d3ed63c0880db396b9c395fb4bf6b559"

PV = "2.7.15+git${SRCPV}"

S = "${WORKDIR}/git"

inherit cmake pkgconfig

DEPENDS = "\
    liborcania \
    libyder \
    libhoel \
    libmicrohttpd \
    jansson \
    gnutls \
    zlib \
"

PACKAGECONFIG ??= "curl"
PACKAGECONFIG[curl] = "-DWITH_CURL=ON,-DWITH_CURL=OFF,curl"
PACKAGECONFIG[websocket] = "-DWITH_WEBSOCKET=ON,-DWITH_WEBSOCKET=OFF,libmicrohttpd"

EXTRA_OECMAKE = "\
    -DBUILD_SHARED_LIBS=ON \
    -DBUILD_ULFIUS_TESTING=OFF \
    -DBUILD_ULFIUS_DOCUMENTATION=OFF \
"

FILES:${PN} += "\
    ${libdir}/libulfius*.so.* \
"

FILES:${PN}-dev += "\
    ${includedir}/ulfius.h \
    ${libdir}/libulfius.so \
    ${libdir}/pkgconfig/*.pc \
    ${libdir}/cmake/Ulfius/* \
"
