SUMMARY = "WiFi configuration"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

inherit systemd

SYSTEMD_AUTO_ENABLE = "enable"

SRC_URI += " \
  file://wpa_supplicant.conf \
  file://25-wlan.network \
"

S = "${WORKDIR}"

do_install() {

    install -d ${D}${sysconfdir}/wpa_supplicant

    install -m 600 ${WORKDIR}/wpa_supplicant.conf \
        ${D}${sysconfdir}/wpa_supplicant/wpa_supplicant-wlan0.conf

    install -d ${D}${sysconfdir}/systemd/network

    install -m 644 ${WORKDIR}/25-wlan.network \
      ${D}${sysconfdir}/systemd/network/25-wlan.network

    install -d ${D}${sysconfdir}/systemd/system/multi-user.target.wants

    ln -s \
      /lib/systemd/system/wpa_supplicant@.service \
      ${D}${sysconfdir}/systemd/system/multi-user.target.wants/wpa_supplicant@wlan0.service

    ln -s \
        /lib/systemd/system/systemd-networkd.service \
        ${D}${sysconfdir}/systemd/system/multi-user.target.wants/systemd-networkd.service
}

FILES:${PN} += " \
  ${sysconfdir}/wpa_supplicant/wpa_supplicant-wlan0.conf \
  ${sysconfdir}/systemd/network/25-wlan.network \
"

IMAGE_INSTALL:append = " wpa-supplicant systemd-networkd "
