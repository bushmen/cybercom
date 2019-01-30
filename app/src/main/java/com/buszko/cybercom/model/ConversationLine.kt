package com.buszko.cybercom.model

import org.simpleframework.xml.*


@Root(name = "line", strict = false)
class ConversationLine {
    @field:Attribute(name = "label", required = false) var label: String? = null
    @field:Text() var line: String? = null
}