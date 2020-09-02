package dao;

import entity.Music;
import util.DBUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MusicDao {
    public List<Music> findMusic(){
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Music> musicList = new ArrayList<>();

        try{
            String sql = "select * from music";
            connection = DBUtils.getConnection();
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()){
                Music music = new Music();
                music.setId(rs.getInt("id"));
                music.setTitle(rs.getString("title"));
                music.setSinger(rs.getString("singer"));
                music.setTime(rs.getDate("time"));
                music.setUrl(rs.getString("url"));
                music.setUserid(rs.getInt("userid"));
                musicList.add(music);


            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.getClose(connection,ps,rs);

        }
        return musicList;

    }


    /**
     * 根据id查找音乐
     */
    public  Music findMusicById(int id){
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Music music = null;
        try{
            String sql = "select * from music where id=?";
            connection = DBUtils.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setInt(1,id);
            rs = ps.executeQuery();
            if(rs.next()){
                music = new Music();
                music.setId(rs.getInt("id"));
                music.setTitle(rs.getString("title"));
                music.setSinger(rs.getString("singer"));
                music.setTime(rs.getDate("time"));
                music.setUrl(rs.getString("url"));
                music.setUserid(rs.getInt("userid"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.getClose(connection,ps,rs);
        }
        return music;
    }
    /**
     * 根据关键字查询音乐
     */

    public  List<Music> ifMusic(String str){
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        List<Music> musicList = new ArrayList<>();

        try{
            String sql = "select * from music where title like '%" + str + "%'";
            connection = DBUtils.getConnection();
            ps = connection.prepareStatement(sql);

            rs = ps.executeQuery();

            while (rs.next()){
                Music music = new Music();
                music.setId(rs.getInt("id"));
                music.setTitle(rs.getString("title"));
                music.setSinger(rs.getString("singer"));
                music.setTime(rs.getDate("time"));
                music.setUrl(rs.getString("url"));
                music.setUserid(rs.getInt("userid"));
                musicList.add(music);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.getClose(connection,ps,rs);
        }
        return musicList;
    }
    /*
    上传音乐
     */
    public  int insert(String title,String singer,String time,String url,int userid){
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try{
            String sql = "insert into music (title, singer, time, url, userid) values(?,?,?,?,?)";
            connection = DBUtils.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1,title);
            ps.setString(2,singer);
            ps.setString(3,time);
            ps.setString(4,url);
            ps.setInt(5,userid);


            int ret = ps.executeUpdate();
            if(ret == 1){
                return 1;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.getClose(connection,ps,null);
        }
        return 0;
    }
    /*
    删除音乐
     */
    public  int deleteMusicById(int id){
        Connection connection = null;
        PreparedStatement ps = null;

        try{
            String sql = "delete from music where id = ?";
            connection = DBUtils.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setInt(1,id);
            int ret = ps.executeUpdate();
            if(ret == 1){
                //删除music表中的数据成功
                if(findLoveMusicOnDel(id)){
                    int ret2 = removeLoveMusic(id);
                    if(ret2 == 1){
                        return 1;
                    }
                }
                return 1;//表示这首歌没有被添加到lovemusic表中
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.getClose(connection,ps,null);
        }
        return 0;
    }
    public  boolean findLoveMusicOnDel(int id){
       Connection connection = null;
       PreparedStatement ps = null;
       ResultSet rs = null;

       try{
           String sql = "select * from lovemusic where id = ?";
           connection = DBUtils.getConnection();
           ps = connection.prepareStatement(sql);
           ps.setInt(1,id);
           rs = ps.executeQuery();

           if(rs.next()){
               return true;
           }


       } catch (SQLException e) {
           e.printStackTrace();
       }finally {
           DBUtils.getClose(connection,ps,null);
       }
       return false;
    }
    public  int removeLoveMusic(int id){
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int ret = 0;

        try{
            String sql = "delete from lovemusic where id = ?";
            connection = DBUtils.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setInt(1,id);
            ret = ps.executeUpdate();
            } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.getClose(connection,ps,null);
        }
        return ret;

    }
    /*
    判断该音乐是否已经添加至喜欢列表
     */
    public boolean findMusicByMusicId(int user_id,int musicID){
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int ret = 0;

        try{
            String sql = "select * from lovemusic where user_id=? and music_id=?";
            connection = DBUtils.getConnection();
            ps = connection.prepareStatement(sql);

            ps.setInt(1,user_id);
            ps.setInt(2,musicID);
            rs = ps.executeQuery();

            if(rs.next()){
                return  true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.getClose(connection,ps,null);
        }
        return false;
    }
    /*
    增添喜欢的音乐
     */
    public  boolean insertLoveMusic(int userId,int musicId){
        Connection connection = null;
        PreparedStatement ps = null;

        int ret = 0;

        try{
            String sql = "insert into lovemusic(user_id, music_id) value (?,?)";
            connection = DBUtils.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setInt(1,userId);
            ps.setInt(2,musicId);
            ret = ps.executeUpdate();

            if(ret == 1){
                return  true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.getClose(connection,ps,null);
        }
        return false;
    }
    /*
    取消喜欢的音乐
     */
    public int removeLoveMusic(int userId,int musicId){
        Connection connection = null;
        PreparedStatement ps = null;

        int ret = 0;

        try{
            String sql = "delete from lovemusic where user_id = ? and music_id = ?";
            connection = DBUtils.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setInt(1,userId);
            ps.setInt(2,musicId);
            ret = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.getClose(connection,ps,null);
        }
        return ret;
    }
    /*
    查询喜欢音乐的列表
     */
    public  List<Music> findLoveMusic(int user_id){
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Music> musicList = new ArrayList<>();

        try{
            String sql = "select m.id as music_id,title,singer,time,url,userid from lovemusic lm, music m where lm.music_id=m.id and user_id=?";
            connection = DBUtils.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setInt(1,user_id);
            rs = ps.executeQuery();
            while (rs.next()){
                Music music = new Music();
                music.setId(rs.getInt("music_id"));
                music.setTitle(rs.getString("title"));
                music.setSinger(rs.getString("singer"));
                music.setTime(rs.getDate("time"));
                music.setUrl(rs.getString("url"));
                music.setUserid(rs.getInt("userid"));
                musicList.add(music);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.getClose(connection,ps,rs);
        }
        return musicList;
    }
    /*
    根据关键字查询喜欢音乐列表中的音乐
     */
    public  List<Music> ifMusicLove(String str,int user_id){
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Music> musicList = new ArrayList<>();

        try{
            String sql = "select m.id as music_id,title,singer,time,url,userid from lovemusic lm, music m where lm.music_id=m.id and user_id=? and title like'%" +str+"%'";
            connection = DBUtils.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setInt(1,user_id);
            rs = ps.executeQuery();
            while (rs.next()){
                Music music = new Music();
                music.setId(rs.getInt("music_id"));
                music.setTitle(rs.getString("title"));
                music.setSinger(rs.getString("singer"));
                music.setTime(rs.getDate("time"));
                music.setUrl(rs.getString("url"));
                music.setUserid(rs.getInt("userid"));
                musicList.add(music);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.getClose(connection,ps,rs);
        }
        return musicList;
    }
    public static void main(String[] args) {
        /*List<Music> musicList = ifMusic("乡");
        System.out.println(musicList);*/
        // System.out.println(musicList);
        // Music music = findMusicById(1);
        // System.out.println(music);
       // Insert("为你唱首歌","痛仰","2008-8-8","music\\为你唱首歌",1);
       // System.out.println(deleteMusicById(1));
       // System.out.println(insertLoveMusic(1, 2));
      /* List<Music> musicList = ifMusicLove("首",1);
       System.out.println(musicList);*/
    }
}
