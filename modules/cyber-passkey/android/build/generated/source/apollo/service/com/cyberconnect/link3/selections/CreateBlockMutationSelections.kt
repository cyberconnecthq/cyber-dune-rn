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
import com.cyberconnect.link3.type.CreateBlockResponse
import com.cyberconnect.link3.type.CreateBlockResponse_Status
import com.cyberconnect.link3.type.GraphQLString
import kotlin.collections.List

public object CreateBlockMutationSelections {
  private val __createBlock: List<CompiledSelection> = listOf(
        CompiledField.Builder(
          name = "status",
          type = CreateBlockResponse_Status.type.notNull()
        ).build(),
        CompiledField.Builder(
          name = "message",
          type = GraphQLString.type.notNull()
        ).build()
      )

  public val __root: List<CompiledSelection> = listOf(
        CompiledField.Builder(
          name = "createBlock",
          type = CreateBlockResponse.type.notNull()
        ).arguments(listOf(
          CompiledArgument.Builder("input", CompiledVariable("input")).build(),
          CompiledArgument.Builder("profileId", CompiledVariable("profileId")).build()
        ))
        .selections(__createBlock)
        .build()
      )
}
