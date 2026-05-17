SUMMARY = "C utility library from Babelouest"
DESCRIPTION = "Orcania is a C utility library providing data structures, strings, lists, JSON helpers, etc."
HOMEPAGE = "https://github.com/babelouest/orcania"

LICENSE = "LGPL-2.1-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=fc178bcd425090939a8b634d1d6a9594"

SRC_URI = "git://github.com/babelouest/orcania.git;protocol=https;branch=master"

SRCREV = "ffc8b55d09a3488f4f6be38034b33bc64bf8b0ce"
PV = "2.3.3+git${SRCPV}"

S = "${WORKDIR}/git"

inherit cmake pkgconfig

# Orcania is usually standalone, but sometimes needs:
DEPENDS = "\
    jansson \
    openssl \
    zlib \
"

EXTRA_OECMAKE = "\
    -DBUILD_ORCANIA_TESTING=OFF \
    -DBUILD_SHARED_LIBS=ON \
    -DCMAKE_INSTALL_LIBDIR=lib \
"

# Install libs
FILES:${PN} += "\
    ${libdir}/liborcania*.so.* \
"

FILES:${PN}-dev += "\
    ${includedir}/orcania.h \
    ${libdir}/liborcania.so \
    ${libdir}/pkgconfig/*.pc \
    ${libdir}/cmake/Orcania/* \
"
