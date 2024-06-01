//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.2'.
//
package com.cyberconnect.link3.type

import com.apollographql.apollo3.api.EnumType
import kotlin.Array
import kotlin.String

public enum class BlockType(
  public val rawValue: String,
) {
  LINK("LINK"),
  SUPERLINK("SUPERLINK"),
  TWITTER("TWITTER"),
  CREDENTIAL("CREDENTIAL"),
  NFT_GALLERY("NFT_GALLERY"),
  W3ST_GALLERY("W3ST_GALLERY"),
  SNAPSHOT("SNAPSHOT"),
  NFT_COLLECTION("NFT_COLLECTION"),
  EVENT("EVENT"),
  POSTS("POSTS"),
  SKILL("SKILL"),
  WORK_EXPERIENCE("WORK_EXPERIENCE"),
  EDUCATION("EDUCATION"),
  CONTACT("CONTACT"),
  RECOMMENDATION("RECOMMENDATION"),
  /**
   * Auto generated constant for unknown enum values
   */
  UNKNOWN__("UNKNOWN__"),
  ;

  public companion object {
    public val type: EnumType = EnumType("BlockType", listOf("LINK", "SUPERLINK", "TWITTER",
        "CREDENTIAL", "NFT_GALLERY", "W3ST_GALLERY", "SNAPSHOT", "NFT_COLLECTION", "EVENT", "POSTS",
        "SKILL", "WORK_EXPERIENCE", "EDUCATION", "CONTACT", "RECOMMENDATION"))

    public fun safeValueOf(rawValue: String): BlockType = values().find { it.rawValue == rawValue }
        ?: UNKNOWN__

    /**
     * Returns all [BlockType] known at compile time
     */
    public fun knownValues(): Array<BlockType> = arrayOf(
      LINK,
      SUPERLINK,
      TWITTER,
      CREDENTIAL,
      NFT_GALLERY,
      W3ST_GALLERY,
      SNAPSHOT,
      NFT_COLLECTION,
      EVENT,
      POSTS,
      SKILL,
      WORK_EXPERIENCE,
      EDUCATION,
      CONTACT,
      RECOMMENDATION)
  }
}
