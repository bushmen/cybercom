package com.buszko.cybercom.model

import org.simpleframework.xml.Element
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root

@Root(name = "tumblr", strict = false)
class TumblrResult {
    @field:Element(name = "tumblelog") var tumblelog: TumbleLog? = null
    @field:ElementList(name = "posts") var posts: List<TumblrPost>? = null
}