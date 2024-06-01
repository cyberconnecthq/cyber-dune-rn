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
import com.cyberconnect.link3.type.GraphQLID
import com.cyberconnect.link3.type.GraphQLString
import com.cyberconnect.link3.type.InitPaidMessageResponse
import com.cyberconnect.link3.type.InitPaidMessageResponse_Status
import com.cyberconnect.link3.type.Message
import kotlin.collections.List

public object InitPaidMessageMutationSelections {
  private val __message: List<CompiledSelection> = listOf(
        CompiledField.Builder(
          name = "id",
          type = GraphQLID.type.notNull()
        ).build()
      )

  private val __initPaidMessage: List<CompiledSelection> = listOf(
        CompiledField.Builder(
          name = "status",
          type = InitPaidMessageResponse_Status.type.notNull()
        ).build(),
        CompiledField.Builder(
          name = "message",
          type = Message.type
        ).selections(__message)
        .build(),
        CompiledField.Builder(
          name = "sponsorSig",
          type = GraphQLString.type.notNull()
        ).build()
      )

  public val __root: List<CompiledSelection> = listOf(
        CompiledField.Builder(
          name = "initPaidMessage",
          type = InitPaidMessageResponse.type.notNull()
        ).arguments(listOf(
          CompiledArgument.Builder("input", CompiledVariable("input")).build()
        ))
        .selections(__initPaidMessage)
        .build()
      )
}