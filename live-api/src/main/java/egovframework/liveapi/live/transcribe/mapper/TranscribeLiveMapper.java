package egovframework.liveapi.live.transcribe.mapper;

import egovframework.liveapi.cmm.mapper.CommonMapperUtil;
import egovframework.liveapi.live.transcribe.domain.TranscribeResult;
import egovframework.liveapi.live.transcribe.dto.TranscribeResultDto;
import org.bson.types.ObjectId;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",imports = ObjectId.class, uses = CommonMapperUtil.class)
public interface TranscribeLiveMapper {

    TranscribeLiveMapper INSTANCE = Mappers.getMapper(TranscribeLiveMapper.class);

    TranscribeResultDto toDto(TranscribeResult entity);

    TranscribeResult toEntity(TranscribeResultDto dto);

}
