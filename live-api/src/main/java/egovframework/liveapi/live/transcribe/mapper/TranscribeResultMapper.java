package egovframework.liveapi.live.transcribe.mapper;

import org.bson.types.ObjectId;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import egovframework.liveapi.cmm.mapper.CommonMapperUtil;
import egovframework.liveapi.live.transcribe.domain.TranscribeResult;
import egovframework.liveapi.live.transcribe.dto.TranscribeResultDto;

@Mapper(componentModel = "spring",imports = ObjectId.class, uses = CommonMapperUtil.class)
public interface TranscribeResultMapper {

    TranscribeResultMapper INSTANCE = Mappers.getMapper(TranscribeResultMapper.class);

    TranscribeResultDto toDto(TranscribeResult entity);

    TranscribeResult toEntity(TranscribeResultDto dto);

}
