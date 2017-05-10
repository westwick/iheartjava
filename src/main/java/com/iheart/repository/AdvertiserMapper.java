package com.iheart.repository;

import com.iheart.model.Advertiser;
import org.apache.ibatis.annotations.*;

/**
 * Created by Andrew on 5/9/2017.
 */
@Mapper
public interface AdvertiserMapper {
    @Insert("insert into advertisers(advertiserName, contactName, creditLimit) values (#{advertiserName}, #{contactName}, #{creditLimit})")
    void insert(Advertiser advertiser);

    @Update("update advertisers set advertiserName=#{advertiserName}, contactName=#{contactName}, creditLimit=#{creditLimit} where id=#{id}")
    void update(Advertiser advertiser);

    @Delete("delete from advertisers where id=#{id}")
    void delete(Advertiser advertiser);

    @Select("select * from advertisers where id=#{id}")
    Advertiser get(Integer id);
}
