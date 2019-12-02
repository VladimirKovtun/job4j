<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="xml" version="1.0" encoding="utf-8" indent="yes"/>
    <xsl:template match="/">
        <entities>
            <xsl:for-each select= "entities/entity">
               <entity>
                   <xsl:attribute name="field">
                       <xsl:value-of select="field"/>
                   </xsl:attribute>
               </entity>
            </xsl:for-each>
        </entities>
    </xsl:template>

</xsl:stylesheet>