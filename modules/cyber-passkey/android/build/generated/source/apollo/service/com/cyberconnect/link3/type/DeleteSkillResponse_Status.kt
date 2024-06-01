//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.2'.
//
package com.cyberconnect.link3.type

import com.apollographql.apollo3.api.EnumType
import kotlin.Array
import kotlin.String

public enum class DeleteSkillResponse_Status(
  public val rawValue: String,
) {
  SUCCESS("SUCCESS"),
  NOT_LOGIN("NOT_LOGIN"),
  SKILL_NOT_FOUND("SKILL_NOT_FOUND"),
  PERMISSION_DENIED("PERMISSION_DENIED"),
  /**
   * Auto generated constant for unknown enum values
   */
  UNKNOWN__("UNKNOWN__"),
  ;

  public companion object {
    public val type: EnumType = EnumType("DeleteSkillResponse_Status", listOf("SUCCESS",
        "NOT_LOGIN", "SKILL_NOT_FOUND", "PERMISSION_DENIED"))

    public fun safeValueOf(rawValue: String): DeleteSkillResponse_Status =
        values().find { it.rawValue == rawValue } ?: UNKNOWN__

    /**
     * Returns all [DeleteSkillResponse_Status] known at compile time
     */
    public fun knownValues(): Array<DeleteSkillResponse_Status> = arrayOf(
      SUCCESS,
      NOT_LOGIN,
      SKILL_NOT_FOUND,
      PERMISSION_DENIED)
  }
}
