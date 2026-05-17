SUMMARY = "Meshtastic configuration"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI += " \
  file://my.yaml \
  file://meshtastic-certgen.sh \
  file://meshtastic-certgen.service \
"

S = "${WORKDIR}"

inherit systemd

SYSTEMD_SERVICE:${PN} += "meshtastic-certgen.service"

do_install() {
    install -d ${D}${sysconfdir}/meshtasticd/config.d
    install -m 0644 ${WORKDIR}/my.yaml ${D}${sysconfdir}/meshtasticd/config.d/my.yaml

    install -d ${D}/usr/bin
    install -m 0755 ${WORKDIR}/meshtastic-certgen.sh ${D}/usr/bin/meshtastic-certgen.sh

    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${WORKDIR}/meshtastic-certgen.service ${D}${systemd_system_unitdir}/meshtastic-certgen.service
}

FILES:${PN} += "${sysconfdir}/meshtasticd/config.d/my.yaml"

RDEPENDS:${PN} += "openssl-bin"
