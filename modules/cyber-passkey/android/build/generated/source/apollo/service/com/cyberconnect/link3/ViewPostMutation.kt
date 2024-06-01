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
import com.cyberconnect.link3.adapter.ViewPostMutation_ResponseAdapter
import com.cyberconnect.link3.adapter.ViewPostMutation_VariablesAdapter
import com.cyberconnect.link3.selections.ViewPostMutationSelections
import com.cyberconnect.link3.type.ViewPostRequest
import com.cyberconnect.link3.type.ViewPostResponse_Status
import kotlin.String
import kotlin.Unit

public data class ViewPostMutation(
  public val input: ViewPostRequest,
) : Mutation<ViewPostMutation.Data> {
  public override fun id(): String = OPERATION_ID

  public override fun document(): String = OPERATION_DOCUMENT

  public override fun name(): String = OPERATION_NAME

  public override fun serializeVariables(writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters): Unit {
    ViewPostMutation_VariablesAdapter.toJson(writer, customScalarAdapters, this)
  }

  public override fun adapter(): Adapter<Data> = ViewPostMutation_ResponseAdapter.Data.obj()

  public override fun rootField(): CompiledField = CompiledField.Builder(
    name = "data",
    type = com.cyberconnect.link3.type.Mutation.type
  )
  .selections(selections = ViewPostMutationSelections.__root)
  .build()

  @ApolloAdaptableWith(ViewPostMutation_ResponseAdapter.Data::class)
  public data class Data(
    public val viewPost: ViewPost,
  ) : Mutation.Data

  public data class ViewPost(
    public val status: ViewPostResponse_Status,
  )

  public companion object {
    public const val OPERATION_ID: String =
        "737a4ca40d761f59ac92c9d6e836a7410255bde2a23e64936f674e6b16de2066"

    /**
     * The minimized GraphQL document being sent to the server to save a few bytes.
     * The un-minimized version is:
     *
     * mutation viewPost($input: ViewPostRequest!) {
     *   viewPost(input: $input) {
     *     status
     *   }
     * }
     */
    public val OPERATION_DOCUMENT: String
      get() =
          "mutation viewPost(${'$'}input: ViewPostRequest!) { viewPost(input: ${'$'}input) { status } }"

    public const val OPERATION_NAME: String = "viewPost"
  }
}