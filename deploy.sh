#!/bin/bash

target=/dev/sda

sudo umount $target*
sudo bmaptool copy my-image-raspberrypi0-wifi.rootfs.wic.bz2 $target
