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
import com.cyberconnect.link3.type.DeleteEducationResponse
import com.cyberconnect.link3.type.DeleteEducationResponse_Status
import kotlin.collections.List

public object DeleteEducationMutationSelections {
  private val __deleteEducation: List<CompiledSelection> = listOf(
        CompiledField.Builder(
          name = "status",
          type = DeleteEducationResponse_Status.type.notNull()
        ).build()
      )

  public val __root: List<CompiledSelection> = listOf(
        CompiledField.Builder(
          name = "deleteEducation",
          type = DeleteEducationResponse.type.notNull()
        ).arguments(listOf(
          CompiledArgument.Builder("educationId", CompiledVariable("input")).build()
        ))
        .selections(__deleteEducation)
        .build()
      )
}
