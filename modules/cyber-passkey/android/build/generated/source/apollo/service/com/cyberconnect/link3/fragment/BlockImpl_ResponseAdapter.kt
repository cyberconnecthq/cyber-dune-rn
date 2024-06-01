//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.2'.
//
package com.cyberconnect.link3.fragment

import com.apollographql.apollo3.api.Adapter
import com.apollographql.apollo3.api.BooleanAdapter
import com.apollographql.apollo3.api.CustomScalarAdapters
import com.apollographql.apollo3.api.IntAdapter
import com.apollographql.apollo3.api.StringAdapter
import com.apollographql.apollo3.api.evaluate
import com.apollographql.apollo3.api.json.JsonReader
import com.apollographql.apollo3.api.json.JsonWriter
import com.apollographql.apollo3.api.possibleTypes
import com.cyberconnect.link3.type.BlockType
import com.cyberconnect.link3.type.BlockVisibility
import com.cyberconnect.link3.type.adapter.BlockType_ResponseAdapter
import com.cyberconnect.link3.type.adapter.BlockVisibility_ResponseAdapter
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.Unit
import kotlin.collections.List

public object BlockImpl_ResponseAdapter {
  public object Block : Adapter<com.cyberconnect.link3.fragment.Block> {
    public val RESPONSE_NAMES: List<String> = listOf("__typename", "id", "profileId", "type",
        "displayName", "index", "isPlaceHolder", "visibility")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        com.cyberconnect.link3.fragment.Block {
      var __typename: String? = null
      var _id: String? = null
      var _profileId: String? = null
      var _type: BlockType? = null
      var _displayName: String? = null
      var _index: Int? = null
      var _isPlaceHolder: Boolean? = null
      var _visibility: BlockVisibility? = null

      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> __typename = StringAdapter.fromJson(reader, customScalarAdapters)
          1 -> _id = StringAdapter.fromJson(reader, customScalarAdapters)
          2 -> _profileId = StringAdapter.fromJson(reader, customScalarAdapters)
          3 -> _type = BlockType_ResponseAdapter.fromJson(reader, customScalarAdapters)
          4 -> _displayName = StringAdapter.fromJson(reader, customScalarAdapters)
          5 -> _index = IntAdapter.fromJson(reader, customScalarAdapters)
          6 -> _isPlaceHolder = BooleanAdapter.fromJson(reader, customScalarAdapters)
          7 -> _visibility = BlockVisibility_ResponseAdapter.fromJson(reader, customScalarAdapters)
          else -> break
        }
      }

      check(__typename != null) {
        "__typename was not found"
      }

      var _linkBlock: LinkBlock? = null
      if (possibleTypes("LinkBlock").evaluate(customScalarAdapters.adapterContext.variables(), __typename, customScalarAdapters.adapterContext, null)) {
        reader.rewind()
        _linkBlock = com.cyberconnect.link3.fragment.LinkBlockImpl_ResponseAdapter.LinkBlock.fromJson(reader,
            customScalarAdapters)
      }

      var _superLinkBlock: SuperLinkBlock? = null
      if (possibleTypes("SuperLinkBlock").evaluate(customScalarAdapters.adapterContext.variables(), __typename, customScalarAdapters.adapterContext, null)) {
        reader.rewind()
        _superLinkBlock = com.cyberconnect.link3.fragment.SuperLinkBlockImpl_ResponseAdapter.SuperLinkBlock.fromJson(reader,
            customScalarAdapters)
      }

      var _twitterBlock: TwitterBlock? = null
      if (possibleTypes("TwitterBlock").evaluate(customScalarAdapters.adapterContext.variables(), __typename, customScalarAdapters.adapterContext, null)) {
        reader.rewind()
        _twitterBlock = com.cyberconnect.link3.fragment.TwitterBlockImpl_ResponseAdapter.TwitterBlock.fromJson(reader,
            customScalarAdapters)
      }

      var _nFTBlock: NFTBlock? = null
      if (possibleTypes("NFTBlock").evaluate(customScalarAdapters.adapterContext.variables(), __typename, customScalarAdapters.adapterContext, null)) {
        reader.rewind()
        _nFTBlock = com.cyberconnect.link3.fragment.NFTBlockImpl_ResponseAdapter.NFTBlock.fromJson(reader,
            customScalarAdapters)
      }

      var _credentialBlock: CredentialBlock? = null
      if (possibleTypes("CredentialBlock").evaluate(customScalarAdapters.adapterContext.variables(), __typename, customScalarAdapters.adapterContext, null)) {
        reader.rewind()
        _credentialBlock = com.cyberconnect.link3.fragment.CredentialBlockImpl_ResponseAdapter.CredentialBlock.fromJson(reader,
            customScalarAdapters)
      }

      var _w3STBlock: W3STBlock? = null
      if (possibleTypes("W3STBlock").evaluate(customScalarAdapters.adapterContext.variables(), __typename, customScalarAdapters.adapterContext, null)) {
        reader.rewind()
        _w3STBlock = com.cyberconnect.link3.fragment.W3STBlockImpl_ResponseAdapter.W3STBlock.fromJson(reader,
            customScalarAdapters)
      }

      var _eventBlock: EventBlock? = null
      if (possibleTypes("EventBlock").evaluate(customScalarAdapters.adapterContext.variables(), __typename, customScalarAdapters.adapterContext, null)) {
        reader.rewind()
        _eventBlock = com.cyberconnect.link3.fragment.EventBlockImpl_ResponseAdapter.EventBlock.fromJson(reader,
            customScalarAdapters)
      }

      var _nFTCollectionBlock: NFTCollectionBlock? = null
      if (possibleTypes("NFTCollectionBlock").evaluate(customScalarAdapters.adapterContext.variables(), __typename, customScalarAdapters.adapterContext, null)) {
        reader.rewind()
        _nFTCollectionBlock = com.cyberconnect.link3.fragment.NFTCollectionBlockImpl_ResponseAdapter.NFTCollectionBlock.fromJson(reader,
            customScalarAdapters)
      }

      var _snapshotBlock: SnapshotBlock? = null
      if (possibleTypes("SnapshotBlock").evaluate(customScalarAdapters.adapterContext.variables(), __typename, customScalarAdapters.adapterContext, null)) {
        reader.rewind()
        _snapshotBlock = com.cyberconnect.link3.fragment.SnapshotBlockImpl_ResponseAdapter.SnapshotBlock.fromJson(reader,
            customScalarAdapters)
      }

      var _postBlock: PostBlock? = null
      if (possibleTypes("PostBlock").evaluate(customScalarAdapters.adapterContext.variables(), __typename, customScalarAdapters.adapterContext, null)) {
        reader.rewind()
        _postBlock = com.cyberconnect.link3.fragment.PostBlockImpl_ResponseAdapter.PostBlock.fromJson(reader,
            customScalarAdapters)
      }

      var _skillBlock: SkillBlock? = null
      if (possibleTypes("SkillBlock").evaluate(customScalarAdapters.adapterContext.variables(), __typename, customScalarAdapters.adapterContext, null)) {
        reader.rewind()
        _skillBlock = com.cyberconnect.link3.fragment.SkillBlockImpl_ResponseAdapter.SkillBlock.fromJson(reader,
            customScalarAdapters)
      }

      var _workExperienceBlock: WorkExperienceBlock? = null
      if (possibleTypes("WorkExperienceBlock").evaluate(customScalarAdapters.adapterContext.variables(), __typename, customScalarAdapters.adapterContext, null)) {
        reader.rewind()
        _workExperienceBlock = com.cyberconnect.link3.fragment.WorkExperienceBlockImpl_ResponseAdapter.WorkExperienceBlock.fromJson(reader,
            customScalarAdapters)
      }

      var _educationBlock: EducationBlock? = null
      if (possibleTypes("EducationBlock").evaluate(customScalarAdapters.adapterContext.variables(), __typename, customScalarAdapters.adapterContext, null)) {
        reader.rewind()
        _educationBlock = com.cyberconnect.link3.fragment.EducationBlockImpl_ResponseAdapter.EducationBlock.fromJson(reader,
            customScalarAdapters)
      }

      var _recommendationBlock: RecommendationBlock? = null
      if (possibleTypes("RecommendationBlock").evaluate(customScalarAdapters.adapterContext.variables(), __typename, customScalarAdapters.adapterContext, null)) {
        reader.rewind()
        _recommendationBlock = com.cyberconnect.link3.fragment.RecommendationBlockImpl_ResponseAdapter.RecommendationBlock.fromJson(reader,
            customScalarAdapters)
      }

      var _contactBlock: ContactBlock? = null
      if (possibleTypes("ContactBlock").evaluate(customScalarAdapters.adapterContext.variables(), __typename, customScalarAdapters.adapterContext, null)) {
        reader.rewind()
        _contactBlock = com.cyberconnect.link3.fragment.ContactBlockImpl_ResponseAdapter.ContactBlock.fromJson(reader,
            customScalarAdapters)
      }

      return com.cyberconnect.link3.fragment.Block(
        __typename = __typename,
        id = _id!!,
        profileId = _profileId!!,
        type = _type!!,
        displayName = _displayName!!,
        index = _index!!,
        isPlaceHolder = _isPlaceHolder!!,
        visibility = _visibility!!,
        linkBlock = _linkBlock,
        superLinkBlock = _superLinkBlock,
        twitterBlock = _twitterBlock,
        nFTBlock = _nFTBlock,
        credentialBlock = _credentialBlock,
        w3STBlock = _w3STBlock,
        eventBlock = _eventBlock,
        nFTCollectionBlock = _nFTCollectionBlock,
        snapshotBlock = _snapshotBlock,
        postBlock = _postBlock,
        skillBlock = _skillBlock,
        workExperienceBlock = _workExperienceBlock,
        educationBlock = _educationBlock,
        recommendationBlock = _recommendationBlock,
        contactBlock = _contactBlock
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: com.cyberconnect.link3.fragment.Block,
    ): Unit {
      writer.name("__typename")
      StringAdapter.toJson(writer, customScalarAdapters, value.__typename)

      writer.name("id")
      StringAdapter.toJson(writer, customScalarAdapters, value.id)

      writer.name("profileId")
      StringAdapter.toJson(writer, customScalarAdapters, value.profileId)

      writer.name("type")
      BlockType_ResponseAdapter.toJson(writer, customScalarAdapters, value.type)

      writer.name("displayName")
      StringAdapter.toJson(writer, customScalarAdapters, value.displayName)

      writer.name("index")
      IntAdapter.toJson(writer, customScalarAdapters, value.index)

      writer.name("isPlaceHolder")
      BooleanAdapter.toJson(writer, customScalarAdapters, value.isPlaceHolder)

      writer.name("visibility")
      BlockVisibility_ResponseAdapter.toJson(writer, customScalarAdapters, value.visibility)

      if (value.linkBlock != null) {
        com.cyberconnect.link3.fragment.LinkBlockImpl_ResponseAdapter.LinkBlock.toJson(writer,
            customScalarAdapters, value.linkBlock)
      }

      if (value.superLinkBlock != null) {
        com.cyberconnect.link3.fragment.SuperLinkBlockImpl_ResponseAdapter.SuperLinkBlock.toJson(writer,
            customScalarAdapters, value.superLinkBlock)
      }

      if (value.twitterBlock != null) {
        com.cyberconnect.link3.fragment.TwitterBlockImpl_ResponseAdapter.TwitterBlock.toJson(writer,
            customScalarAdapters, value.twitterBlock)
      }

      if (value.nFTBlock != null) {
        com.cyberconnect.link3.fragment.NFTBlockImpl_ResponseAdapter.NFTBlock.toJson(writer,
            customScalarAdapters, value.nFTBlock)
      }

      if (value.credentialBlock != null) {
        com.cyberconnect.link3.fragment.CredentialBlockImpl_ResponseAdapter.CredentialBlock.toJson(writer,
            customScalarAdapters, value.credentialBlock)
      }

      if (value.w3STBlock != null) {
        com.cyberconnect.link3.fragment.W3STBlockImpl_ResponseAdapter.W3STBlock.toJson(writer,
            customScalarAdapters, value.w3STBlock)
      }

      if (value.eventBlock != null) {
        com.cyberconnect.link3.fragment.EventBlockImpl_ResponseAdapter.EventBlock.toJson(writer,
            customScalarAdapters, value.eventBlock)
      }

      if (value.nFTCollectionBlock != null) {
        com.cyberconnect.link3.fragment.NFTCollectionBlockImpl_ResponseAdapter.NFTCollectionBlock.toJson(writer,
            customScalarAdapters, value.nFTCollectionBlock)
      }

      if (value.snapshotBlock != null) {
        com.cyberconnect.link3.fragment.SnapshotBlockImpl_ResponseAdapter.SnapshotBlock.toJson(writer,
            customScalarAdapters, value.snapshotBlock)
      }

      if (value.postBlock != null) {
        com.cyberconnect.link3.fragment.PostBlockImpl_ResponseAdapter.PostBlock.toJson(writer,
            customScalarAdapters, value.postBlock)
      }

      if (value.skillBlock != null) {
        com.cyberconnect.link3.fragment.SkillBlockImpl_ResponseAdapter.SkillBlock.toJson(writer,
            customScalarAdapters, value.skillBlock)
      }

      if (value.workExperienceBlock != null) {
        com.cyberconnect.link3.fragment.WorkExperienceBlockImpl_ResponseAdapter.WorkExperienceBlock.toJson(writer,
            customScalarAdapters, value.workExperienceBlock)
      }

      if (value.educationBlock != null) {
        com.cyberconnect.link3.fragment.EducationBlockImpl_ResponseAdapter.EducationBlock.toJson(writer,
            customScalarAdapters, value.educationBlock)
      }

      if (value.recommendationBlock != null) {
        com.cyberconnect.link3.fragment.RecommendationBlockImpl_ResponseAdapter.RecommendationBlock.toJson(writer,
            customScalarAdapters, value.recommendationBlock)
      }

      if (value.contactBlock != null) {
        com.cyberconnect.link3.fragment.ContactBlockImpl_ResponseAdapter.ContactBlock.toJson(writer,
            customScalarAdapters, value.contactBlock)
      }
    }
  }
}
