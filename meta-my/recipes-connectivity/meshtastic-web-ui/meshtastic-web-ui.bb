SUMMARY = "Meshtastic Web UI"
DESCRIPTION = "Static web interface for meshtasticd"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "https://github.com/meshtastic/web/releases/download/v2.6.7/build.tar;subdir=meshtastic-web"

SRC_URI[sha256sum] = "a34f4360a0486543a698de20de533557492e763ab459fc27fcea95d0495144ed"

S = "${WORKDIR}/meshtastic-web"

inherit allarch

do_install() {
    install -d ${D}/usr/share/meshtasticd/web
    cp -r ${S}/. ${D}/usr/share/meshtasticd/web/

    # Decompress all *.gz files in place
    find ${D}/usr/share/meshtasticd/web -type f -name '*.gz' | while read f; do
        gunzip "$f"
    done
}

FILES:${PN} += "/usr/share/meshtasticd/web"

DEPENDS += "gzip-native"
