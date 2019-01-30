package com.buszko.cybercom.model

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

@Root(name = "tumblelog", strict = false)
class TumbleLog {
    @field:Element(name = "title", required = false) var title: String? = null
    @field:Element(name = "description", required = false) var description: String? = null
}