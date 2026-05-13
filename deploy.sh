#!/bin/bash

target=/dev/sda

sudo umount ${target}1
sudo umount ${target}2
sudo bmaptool copy build/tmp/deploy/images/raspberrypi0-wifi/my-image-raspberrypi0-wifi.rootfs.wic.bz2 $target
sudo sync
sudo partprobe $target
