//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.2'.
//
package com.cyberconnect.link3.type

import com.apollographql.apollo3.api.EnumType
import kotlin.Array
import kotlin.String

public enum class ClaimEasAttestationResponse_Status(
  public val rawValue: String,
) {
  SUCCESS("SUCCESS"),
  NOT_LOGIN("NOT_LOGIN"),
  PERSONAL_NOT_VERIFIED("PERSONAL_NOT_VERIFIED"),
  ORG_EAS_NOT_FOUND("ORG_EAS_NOT_FOUND"),
  ALREADY_ATTESTED("ALREADY_ATTESTED"),
  /**
   * Auto generated constant for unknown enum values
   */
  UNKNOWN__("UNKNOWN__"),
  ;

  public companion object {
    public val type: EnumType = EnumType("ClaimEasAttestationResponse_Status", listOf("SUCCESS",
        "NOT_LOGIN", "PERSONAL_NOT_VERIFIED", "ORG_EAS_NOT_FOUND", "ALREADY_ATTESTED"))

    public fun safeValueOf(rawValue: String): ClaimEasAttestationResponse_Status =
        values().find { it.rawValue == rawValue } ?: UNKNOWN__

    /**
     * Returns all [ClaimEasAttestationResponse_Status] known at compile time
     */
    public fun knownValues(): Array<ClaimEasAttestationResponse_Status> = arrayOf(
      SUCCESS,
      NOT_LOGIN,
      PERSONAL_NOT_VERIFIED,
      ORG_EAS_NOT_FOUND,
      ALREADY_ATTESTED)
  }
}
