//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.2'.
//
package com.cyberconnect.link3.selections

import com.apollographql.apollo3.api.CompiledArgument
import com.apollographql.apollo3.api.CompiledField
import com.apollographql.apollo3.api.CompiledSelection
import com.apollographql.apollo3.api.CompiledVariable
import com.apollographql.apollo3.api.notNull
import com.cyberconnect.link3.type.EasWhitelistVerifyStatus
import com.cyberconnect.link3.type.SubmitEasWhitelistResponse
import com.cyberconnect.link3.type.SubmitEasWhitelistResponse_Status
import kotlin.collections.List

public object VerifyEasMutationSelections {
  private val __submitEasWhitelist: List<CompiledSelection> = listOf(
        CompiledField.Builder(
          name = "status",
          type = SubmitEasWhitelistResponse_Status.type.notNull()
        ).build(),
        CompiledField.Builder(
          name = "verifyStatus",
          type = EasWhitelistVerifyStatus.type.notNull()
        ).build()
      )

  public val __root: List<CompiledSelection> = listOf(
        CompiledField.Builder(
          name = "submitEasWhitelist",
          type = SubmitEasWhitelistResponse.type.notNull()
        ).arguments(listOf(
          CompiledArgument.Builder("input", CompiledVariable("input")).build()
        ))
        .selections(__submitEasWhitelist)
        .build()
      )
}