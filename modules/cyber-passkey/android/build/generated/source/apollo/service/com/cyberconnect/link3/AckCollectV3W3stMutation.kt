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
import com.cyberconnect.link3.adapter.AckCollectV3W3stMutation_ResponseAdapter
import com.cyberconnect.link3.adapter.AckCollectV3W3stMutation_VariablesAdapter
import com.cyberconnect.link3.selections.AckCollectV3W3stMutationSelections
import com.cyberconnect.link3.type.AckCollectV3W3STRequest
import com.cyberconnect.link3.type.AckCollectV3W3STResponse_Status
import kotlin.String
import kotlin.Unit

public data class AckCollectV3W3stMutation(
  public val ackRequest: AckCollectV3W3STRequest,
) : Mutation<AckCollectV3W3stMutation.Data> {
  public override fun id(): String = OPERATION_ID

  public override fun document(): String = OPERATION_DOCUMENT

  public override fun name(): String = OPERATION_NAME

  public override fun serializeVariables(writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters): Unit {
    AckCollectV3W3stMutation_VariablesAdapter.toJson(writer, customScalarAdapters, this)
  }

  public override fun adapter(): Adapter<Data> = AckCollectV3W3stMutation_ResponseAdapter.Data.obj()

  public override fun rootField(): CompiledField = CompiledField.Builder(
    name = "data",
    type = com.cyberconnect.link3.type.Mutation.type
  )
  .selections(selections = AckCollectV3W3stMutationSelections.__root)
  .build()

  @ApolloAdaptableWith(AckCollectV3W3stMutation_ResponseAdapter.Data::class)
  public data class Data(
    public val ackCollectV3W3ST: AckCollectV3W3ST,
  ) : Mutation.Data

  public data class AckCollectV3W3ST(
    public val status: AckCollectV3W3STResponse_Status,
  )

  public companion object {
    public const val OPERATION_ID: String =
        "bd883faca8f19686f61a67655270c503cd2bb2dcf15a8470076c507d0c30c38e"

    /**
     * The minimized GraphQL document being sent to the server to save a few bytes.
     * The un-minimized version is:
     *
     * mutation ackCollectV3W3st($ackRequest: AckCollectV3W3STRequest!) {
     *   ackCollectV3W3ST(input: $ackRequest) {
     *     status
     *   }
     * }
     */
    public val OPERATION_DOCUMENT: String
      get() =
          "mutation ackCollectV3W3st(${'$'}ackRequest: AckCollectV3W3STRequest!) { ackCollectV3W3ST(input: ${'$'}ackRequest) { status } }"

    public const val OPERATION_NAME: String = "ackCollectV3W3st"
  }
}
