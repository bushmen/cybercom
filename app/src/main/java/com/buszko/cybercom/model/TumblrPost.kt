package com.buszko.cybercom.model

import org.simpleframework.xml.Attribute
import org.simpleframework.xml.Element
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root


@Root(name = "post", strict = false)
class TumblrPost {

    @field:Attribute(name = "type") var type: PostType? = null
    @field:Element(name = "video-source", required = false) var videoSource: String? = null
    @field:Element(name = "audio-embed", required = false) var audioEmbed: String? = null
    @field:Element(name = "conversation-title", required = false) var conversationTitle: String? = null
    @field:ElementList(name = "conversation", required = false) var converstionLines: List<ConversationLine>? = null
    @field:Element(name = "link-text", required = false) var linkText: String? = null
    @field:Element(name = "link-url", required = false) var linkUrl: String? = null
    @field:Element(name = "quote-text", required = false) var quoteText: String? = null
    @field:Element(name = "quote-source", required = false) var quoteSource: String? = null
    @field:Element(name = "photo-caption", required = false) var photoCaption: String? = null
    @field:ElementList(entry = "photo-url", type = String::class, inline = true, required = false) var photos: List<String>? = null
}