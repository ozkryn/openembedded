DESCRIPTION = "Libcap is a library for getting and setting POSIX.1e (formerly POSIX 6) draft 15 capabilities."
PRIORITY = "optional"
SECTION = "libs"
LICENSE = "GPL"
DEPENDS = "bison-native flex-native attr ${@base_contains('DISTRO_FEATURES', 'pam', 'libpam', '', d)}"
PR = "r3"

BUILD_CFLAGS += "-I${S}/libcap/include"
CFLAGS += "-I${S}/libcap/include"
LDFLAGS =+ "-L../libcap"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/libs/security/linux-privs/libcap2/libcap-${PV}.tar.bz2 \
	   file://make.patch \
	"

S = "${WORKDIR}/libcap-${PV}"

EXTRA_OEMAKE = "SYSTEM_HEADERS=${STAGING_INCDIR}"

do_install() {
	install -d ${D}${includedir}/sys
	install -m 0644 libcap/include/sys/capability.h ${D}${includedir}/sys/
	install -d ${D}${libdir}
	oe_libinstall -s -C libcap libcap ${D}${libdir}
}

SRC_URI[md5sum] = "6e2c9d0f3c3118e41cd07288ba9577ce"
SRC_URI[sha256sum] = "9c5a41a5577d6f702fe4d29e92f91f1d586a2ef272f6b7fa137bae3f0e76cc2f"