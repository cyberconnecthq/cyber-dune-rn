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
import com.cyberconnect.link3.type.UpdateUserRemarkResponse
import com.cyberconnect.link3.type.UpdateUserRemarkResponse_Status
import kotlin.collections.List

public object UpdateUserRemarkMutationSelections {
  private val __updateUserRemark: List<CompiledSelection> = listOf(
        CompiledField.Builder(
          name = "status",
          type = UpdateUserRemarkResponse_Status.type.notNull()
        ).build()
      )

  public val __root: List<CompiledSelection> = listOf(
        CompiledField.Builder(
          name = "updateUserRemark",
          type = UpdateUserRemarkResponse.type.notNull()
        ).arguments(listOf(
          CompiledArgument.Builder("input", CompiledVariable("input")).build()
        ))
        .selections(__updateUserRemark)
        .build()
      )
}
