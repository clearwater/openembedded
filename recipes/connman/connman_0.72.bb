require connman.inc
# connman requires libXtables now
DEPENDS += "iptables"
PR = "r1"

EXTRA_OECONF += "\
  --disable-gtk-doc \
  --enable-debug \
  --enable-threads \
  --enable-loopback \
  --enable-ethernet \
  --enable-wifi \
  --disable-wimax \
  --enable-bluetooth \
  --enable-ofono \
  --enable-resolvconf \
  --enable-dnsproxy \
  --enable-tools \
  --disable-polkit \
  --enable-client \
  --enable-fake \
"

SRC_URI  = "\
  http://www.kernel.org/pub/linux/network/connman/connman-${PV}.tar.gz \
  file://link-against-libnl2.patch \
  file://connman \
"

SRC_URI[md5sum] = "0f46cf553300d745e64738292b9b395d"
SRC_URI[sha256sum] = "097ed6374880bcf4e331d7c786e29d3ad2be802fa57a3e5c6fdaa7bd955062ec"

