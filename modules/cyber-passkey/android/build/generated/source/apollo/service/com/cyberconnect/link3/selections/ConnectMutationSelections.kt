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
import com.cyberconnect.link3.type.ConnectResponse
import com.cyberconnect.link3.type.ConnectResponse_Status
import kotlin.collections.List

public object ConnectMutationSelections {
  private val __connect: List<CompiledSelection> = listOf(
        CompiledField.Builder(
          name = "status",
          type = ConnectResponse_Status.type.notNull()
        ).build()
      )

  public val __root: List<CompiledSelection> = listOf(
        CompiledField.Builder(
          name = "connect",
          type = ConnectResponse.type.notNull()
        ).arguments(listOf(
          CompiledArgument.Builder("input", mapOf(
            "profileId" to CompiledVariable("profileId")
          )).build()
        ))
        .selections(__connect)
        .build()
      )
}
