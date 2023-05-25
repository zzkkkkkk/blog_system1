package com.example.blog_system;

import com.example.blog_system.Mapper.StatisticMapper;
import com.example.blog_system.domain.Article;
import com.example.blog_system.domain.Statistic;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class StatisticMapperTest {

    @Autowired
    private StatisticMapper statisticMapper;


    @Test
    public void testUpdateArticleHitsWithId() {
        Statistic statistic = new Statistic();
        statistic.setArticle_id(1);
        statistic.setHits(20);
        statisticMapper.updateArticleHitsWithId(statistic);
        Statistic result = statisticMapper.selectStatisticWithArticleId(statistic.getArticle_id());
        Assertions.assertEquals(statistic.getHits(), result.getHits());
    }

    @Test
    public void testUpdateArticleCommentsWithId() {
        Statistic statistic = new Statistic();
        statistic.setArticle_id(1);
        statistic.setComments_num(10);
        statisticMapper.updateArticleCommentsWithId(statistic);
        Statistic result = statisticMapper.selectStatisticWithArticleId(statistic.getArticle_id());
        Assertions.assertEquals(statistic.getComments_num(), result.getComments_num());
    }

    @Test
    public void testDeleteStatisticWithId() {
        int articleId = 1;
        statisticMapper.deleteStatisticWithId(articleId);
        Statistic result = statisticMapper.selectStatisticWithArticleId(articleId);
        Assertions.assertNull(result);
    }

    @Test
    public void testGetStatistic() {
        Assertions.assertFalse(statisticMapper.getStatistic().isEmpty());
    }

    @Test
    public void testGetTotalVisit() {
        Assertions.assertTrue(statisticMapper.getTotalVisit() >= 0);
    }

    @Test
    public void testGetTotalComment() {
        Assertions.assertTrue(statisticMapper.getTotalComment() >= 0);
    }
}
