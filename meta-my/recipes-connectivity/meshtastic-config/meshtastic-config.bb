SUMMARY = "Meshtastic configuration"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "file://my.yaml"

S = "${WORKDIR}"

do_install() {
    install -d ${D}${sysconfdir}/meshtasticd/config.d
    install -m 0644 ${WORKDIR}/my.yaml ${D}${sysconfdir}/meshtasticd/config.d/my.yaml
}

FILES:${PN} += "${sysconfdir}/meshtasticd/config.d/my.yaml"
