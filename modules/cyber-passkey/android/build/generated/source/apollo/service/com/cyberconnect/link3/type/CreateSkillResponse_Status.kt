//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.2'.
//
package com.cyberconnect.link3.type

import com.apollographql.apollo3.api.EnumType
import kotlin.Array
import kotlin.String

public enum class CreateSkillResponse_Status(
  public val rawValue: String,
) {
  SUCCESS("SUCCESS"),
  NOT_LOGIN("NOT_LOGIN"),
  PROFILE_NOT_FOUND("PROFILE_NOT_FOUND"),
  PERMISSION_DENIED("PERMISSION_DENIED"),
  DUPLICATE_SKILL("DUPLICATE_SKILL"),
  /**
   * Auto generated constant for unknown enum values
   */
  UNKNOWN__("UNKNOWN__"),
  ;

  public companion object {
    public val type: EnumType = EnumType("CreateSkillResponse_Status", listOf("SUCCESS",
        "NOT_LOGIN", "PROFILE_NOT_FOUND", "PERMISSION_DENIED", "DUPLICATE_SKILL"))

    public fun safeValueOf(rawValue: String): CreateSkillResponse_Status =
        values().find { it.rawValue == rawValue } ?: UNKNOWN__

    /**
     * Returns all [CreateSkillResponse_Status] known at compile time
     */
    public fun knownValues(): Array<CreateSkillResponse_Status> = arrayOf(
      SUCCESS,
      NOT_LOGIN,
      PROFILE_NOT_FOUND,
      PERMISSION_DENIED,
      DUPLICATE_SKILL)
  }
}
