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
import com.cyberconnect.link3.type.ViewPostResponse
import com.cyberconnect.link3.type.ViewPostResponse_Status
import kotlin.collections.List

public object ViewPostMutationSelections {
  private val __viewPost: List<CompiledSelection> = listOf(
        CompiledField.Builder(
          name = "status",
          type = ViewPostResponse_Status.type.notNull()
        ).build()
      )

  public val __root: List<CompiledSelection> = listOf(
        CompiledField.Builder(
          name = "viewPost",
          type = ViewPostResponse.type.notNull()
        ).arguments(listOf(
          CompiledArgument.Builder("input", CompiledVariable("input")).build()
        ))
        .selections(__viewPost)
        .build()
      )
}
