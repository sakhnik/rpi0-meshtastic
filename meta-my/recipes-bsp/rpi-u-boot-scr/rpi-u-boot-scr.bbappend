
do_configure:prepend() {
    sed -i \
      's|fatload mmc 0:1 ${kernel_addr_r} @@KERNEL_IMAGETYPE@@|load ${BOOT_DEV} ${kernel_addr_r} boot/@@KERNEL_IMAGETYPE@@|' \
      ${WORKDIR}/boot.cmd.in
}
