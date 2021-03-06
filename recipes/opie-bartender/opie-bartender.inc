DESCRIPTION = "Bartender drink recipe database"
SECTION = "opie/applications"
PRIORITY = "optional"
LICENSE = "GPL"
APPNAME = "bartender"


S = "${WORKDIR}/opie-bartender"

inherit opie

do_install() {
        install -d ${D}${palmtopdir}/pics/${APPNAME}/
        install -d ${D}${palmtopdir}/etc/${APPNAME}/
	install -m 0644 ${WORKDIR}/pics/${APPNAME}/*.png ${D}${palmtopdir}/pics/${APPNAME}/
	install -m 0644 db/drinkdb.txt  ${D}${palmtopdir}/etc/${APPNAME}/
}
