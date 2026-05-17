SUMMARY = "Logging library from Babelouest"
DESCRIPTION = "Yder is a logging library written in C, part of the Babelouest stack."
HOMEPAGE = "https://github.com/babelouest/yder"

LICENSE = "LGPL-2.1-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=40d2542b8c43a3ec2b7f5da31a697b88"

SRC_URI = "git://github.com/babelouest/yder.git;protocol=https;branch=master"

# Pin to a commit (IMPORTANT: replace with real stable SHA)
SRCREV = "dffe82c0483bb95d0d518ba1e36c568e63a24628"

PV = "1.4.20+git${SRCPV}"

S = "${WORKDIR}/git"

inherit cmake pkgconfig

DEPENDS = "\
    liborcania \
    systemd \
"

EXTRA_OECMAKE = "\
    -DBUILD_YDER_TESTING=OFF \
    -DBUILD_SHARED_LIBS=ON \
"

FILES:${PN} += "\
    ${libdir}/libyder*.so.* \
"

FILES:${PN}-dev += "\
    ${includedir}/yder.h \
    ${libdir}/libyder.so \
    ${libdir}/pkgconfig/*.pc \
    ${libdir}/cmake/Yder/* \
"
