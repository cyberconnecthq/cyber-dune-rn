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
import com.cyberconnect.link3.adapter.WithdrawCreditMutation_ResponseAdapter
import com.cyberconnect.link3.adapter.WithdrawCreditMutation_VariablesAdapter
import com.cyberconnect.link3.selections.WithdrawCreditMutationSelections
import com.cyberconnect.link3.type.WithdrawCreditInput
import com.cyberconnect.link3.type.WithdrawCreditResponse_Status
import kotlin.String
import kotlin.Unit

public data class WithdrawCreditMutation(
  public val input: WithdrawCreditInput,
) : Mutation<WithdrawCreditMutation.Data> {
  public override fun id(): String = OPERATION_ID

  public override fun document(): String = OPERATION_DOCUMENT

  public override fun name(): String = OPERATION_NAME

  public override fun serializeVariables(writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters): Unit {
    WithdrawCreditMutation_VariablesAdapter.toJson(writer, customScalarAdapters, this)
  }

  public override fun adapter(): Adapter<Data> = WithdrawCreditMutation_ResponseAdapter.Data.obj()

  public override fun rootField(): CompiledField = CompiledField.Builder(
    name = "data",
    type = com.cyberconnect.link3.type.Mutation.type
  )
  .selections(selections = WithdrawCreditMutationSelections.__root)
  .build()

  @ApolloAdaptableWith(WithdrawCreditMutation_ResponseAdapter.Data::class)
  public data class Data(
    public val withdrawCredit: WithdrawCredit,
  ) : Mutation.Data

  public data class WithdrawCredit(
    public val status: WithdrawCreditResponse_Status,
  )

  public companion object {
    public const val OPERATION_ID: String =
        "4263f6eff1bb9326c0f032d5717886ceeb7ada35da78e66d97290f28000443e5"

    /**
     * The minimized GraphQL document being sent to the server to save a few bytes.
     * The un-minimized version is:
     *
     * mutation withdrawCredit($input: WithdrawCreditInput!) {
     *   withdrawCredit(input: $input) {
     *     status
     *   }
     * }
     */
    public val OPERATION_DOCUMENT: String
      get() =
          "mutation withdrawCredit(${'$'}input: WithdrawCreditInput!) { withdrawCredit(input: ${'$'}input) { status } }"

    public const val OPERATION_NAME: String = "withdrawCredit"
  }
}
