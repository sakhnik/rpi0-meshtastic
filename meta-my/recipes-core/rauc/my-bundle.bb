inherit bundle

RAUC_BUNDLE_COMPATIBLE = "raspberrypi0-wifi"
RAUC_BUNDLE_VERSION = "${DISTRO_VERSION}+${SRCPV}"
RAUC_BUNDLE_FORMAT = "verity"

RAUC_BUNDLE_SLOTS = "rootfs"

RAUC_SLOT_rootfs = "my-image"
RAUC_SLOT_rootfs[fstype] = "ext4"

RAUC_KEY_FILE = "${THISDIR}/files/development-1.key.pem"
RAUC_CERT_FILE = "${THISDIR}/files/development-1.cert.pem"
