package day14;

import java.util.*;

public class Solution02 {

}

class Twitter {
    private Map<Integer, Set<Integer>> userFollowerMap;
    private Map<Integer, List<Integer>> userTwitterMap;
    private List<Integer> twitterList;
    public Twitter() {
        userFollowerMap = new HashMap<>();
        userTwitterMap = new HashMap<>();
        twitterList = new ArrayList<>();
    }
    public void postTweet(int userId, int tweetId) {
        if (userTwitterMap.get(userId) == null) {
            List<Integer> list = new ArrayList<>();
            userTwitterMap.put(userId, list);
        }
        userTwitterMap.get(userId).add(tweetId);
        twitterList.add(tweetId);
    }
    public List<Integer> getNewsFeed(int userId) {
        Set<Integer> list = new HashSet<>();
        if (userFollowerMap.get(userId) != null) {
            for (Integer user : userFollowerMap.get(userId)) {
                if (userTwitterMap.get(user) != null) {
                    List<Integer> l = userTwitterMap.get(user);
                    if (l.size() <= 10) {
                        list.addAll(l);
                    } else {
                        for (int i = l.size() - 1; i >= l.size() - 10; i--) {
                            list.add(l.get(i));
                        }
                    }
                }
            }
        }
        if (userTwitterMap.get(userId) != null) {
            List<Integer> l1 = userTwitterMap.get(userId);
            if (l1.size() <= 10) {
                list.addAll(l1);
            } else {
                for (int i = l1.size() - 1; i >= l1.size() - 10; i--) {
                    list.add(l1.get(i));
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = twitterList.size() - 1; i >= 0; i--) {
            if (list.contains(twitterList.get(i))) {
                res.add(twitterList.get(i));
            }
            if (res.size() == 10 || res.size() == list.size()) break;
        }
        return res;
    }
    public void follow(int followerId, int followeeId) {
        if (userFollowerMap.get(followerId) == null) {
            Set<Integer> set = new HashSet<>();
            userFollowerMap.put(followerId, set);
        }
        userFollowerMap.get(followerId).add(followeeId);
    }
    public void unfollow(int followerId, int followeeId) {
        if (userFollowerMap.get(followerId) != null)
        userFollowerMap.get(followerId).remove(followeeId);
    }
}
