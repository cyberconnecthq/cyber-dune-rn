//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.2'.
//
package com.cyberconnect.link3

import com.apollographql.apollo3.annotations.ApolloAdaptableWith
import com.apollographql.apollo3.api.Adapter
import com.apollographql.apollo3.api.CompiledField
import com.apollographql.apollo3.api.CustomScalarAdapters
import com.apollographql.apollo3.api.Mutation
import com.apollographql.apollo3.api.json.JsonWriter
import com.apollographql.apollo3.api.obj
import com.cyberconnect.link3.adapter.UpdateBlockVisibilityMutation_ResponseAdapter
import com.cyberconnect.link3.adapter.UpdateBlockVisibilityMutation_VariablesAdapter
import com.cyberconnect.link3.selections.UpdateBlockVisibilityMutationSelections
import com.cyberconnect.link3.type.UpdateBlockVisibilityInput
import com.cyberconnect.link3.type.UpdateBlockVisibilityResponse_Status
import kotlin.String
import kotlin.Unit

public data class UpdateBlockVisibilityMutation(
  public val input: UpdateBlockVisibilityInput,
) : Mutation<UpdateBlockVisibilityMutation.Data> {
  public override fun id(): String = OPERATION_ID

  public override fun document(): String = OPERATION_DOCUMENT

  public override fun name(): String = OPERATION_NAME

  public override fun serializeVariables(writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters): Unit {
    UpdateBlockVisibilityMutation_VariablesAdapter.toJson(writer, customScalarAdapters, this)
  }

  public override fun adapter(): Adapter<Data> =
      UpdateBlockVisibilityMutation_ResponseAdapter.Data.obj()

  public override fun rootField(): CompiledField = CompiledField.Builder(
    name = "data",
    type = com.cyberconnect.link3.type.Mutation.type
  )
  .selections(selections = UpdateBlockVisibilityMutationSelections.__root)
  .build()

  @ApolloAdaptableWith(UpdateBlockVisibilityMutation_ResponseAdapter.Data::class)
  public data class Data(
    public val updateBlockVisibility: UpdateBlockVisibility,
  ) : Mutation.Data

  public data class UpdateBlockVisibility(
    public val status: UpdateBlockVisibilityResponse_Status,
  )

  public companion object {
    public const val OPERATION_ID: String =
        "b28391ebbc00bc7015d6e7f451ecff4bca23504cc4c468b69b506e5d444d8971"

    /**
     * The minimized GraphQL document being sent to the server to save a few bytes.
     * The un-minimized version is:
     *
     * mutation updateBlockVisibility($input: UpdateBlockVisibilityInput!) {
     *   updateBlockVisibility(input: $input) {
     *     status
     *   }
     * }
     */
    public val OPERATION_DOCUMENT: String
      get() =
          "mutation updateBlockVisibility(${'$'}input: UpdateBlockVisibilityInput!) { updateBlockVisibility(input: ${'$'}input) { status } }"

    public const val OPERATION_NAME: String = "updateBlockVisibility"
  }
}
