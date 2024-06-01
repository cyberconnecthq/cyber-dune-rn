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
import com.cyberconnect.link3.type.CollectPermissionPostResponse
import com.cyberconnect.link3.type.CollectPermissionPostResponse_Status
import com.cyberconnect.link3.type.GraphQLInt
import com.cyberconnect.link3.type.GraphQLString
import kotlin.collections.List

public object CollectPermissionPostMutationSelections {
  private val __collectPermissionPost: List<CompiledSelection> = listOf(
        CompiledField.Builder(
          name = "chainId",
          type = GraphQLInt.type.notNull()
        ).build(),
        CompiledField.Builder(
          name = "collectId",
          type = GraphQLString.type.notNull()
        ).build(),
        CompiledField.Builder(
          name = "collector",
          type = GraphQLString.type.notNull()
        ).build(),
        CompiledField.Builder(
          name = "essenceId",
          type = GraphQLInt.type.notNull()
        ).build(),
        CompiledField.Builder(
          name = "preData",
          type = GraphQLString.type.notNull()
        ).build(),
        CompiledField.Builder(
          name = "profileId",
          type = GraphQLInt.type.notNull()
        ).build(),
        CompiledField.Builder(
          name = "status",
          type = CollectPermissionPostResponse_Status.type.notNull()
        ).build()
      )

  public val __root: List<CompiledSelection> = listOf(
        CompiledField.Builder(
          name = "collectPermissionPost",
          type = CollectPermissionPostResponse.type.notNull()
        ).arguments(listOf(
          CompiledArgument.Builder("input", CompiledVariable("input")).build()
        ))
        .selections(__collectPermissionPost)
        .build()
      )
}