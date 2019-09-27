package com.zcl;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * ssm .
 *
 * @description: .
 * @author: Chenglin Zhu .
 * @date: 19-9-18 .
 */
public class MySearchTest2 {
	private final static Executor executor = Executors.newCachedThreadPool();// 启用多线程
	private static String mainUrl = "http://ac.qq.com/Comic/index/state/pink/page/";// 可以根据腾讯漫画的分类来进行抓取
	private static String url = "http://ac.qq.com/Jump";// +/Comic/comicInfo/id/11111
	// 可以获取具体的漫画页面

	public static void main(String[] args) {
		for (int i = 1; i <= 144; i++) {//可以分析漫画的总页数来进行调用
			final int j = i;
			executor.execute(new Runnable() {
				@Override
				public void run() {
					try {
						System.out.println("begin*************第" + j + "页");
						getArticleListFromUrl(mainUrl + j, j);
						System.out.println("end*************第" + j + "页");
					} catch (Exception e) {
						System.err.println("**********************获取漫画错误**********************");
						e.printStackTrace();
					}
				}
			});

		}
	}

	/**
	 * 获取日漫列表
	 *
	 * @param listurl
	 */
	public static void getArticleListFromUrl(String listurl, int j) {
		Document doc = null;
		try {
			doc = Jsoup
					.connect(listurl)
					.userAgent(
							"Mozilla/5.0 (Windows NT 10.0; WOW64; rv:55.0) Gecko/20100101 Firefox/55.0")
					.timeout(3000).get();
		} catch (IOException e) {
			System.err.println("**********************获取评论请求错误**********************");
			e.printStackTrace();
		}
		// System.out.println(doc);
		Elements elements = doc.getElementsByTag("a");// 找到所有a标签
		for (Element element : elements) {
			String relHref = element.attr("href"); // ==
			// "/"这个是href的属性值，一般都是链接。这里放的是漫画的连接
			String linkHref = element.text();
			// 用if语句过滤掉不是漫画链接的内容
			if (!relHref.startsWith("http://")
					&& relHref.contains("/Comic/comicInfo/id")) {
				StringBuffer sb = new StringBuffer();
				sb.append(url).append(relHref);
				String id = sb.substring(sb.lastIndexOf("/") + 1);
				try {
					for (int i = 1; i <= 50; i++) {//默认取50页评论
						getArticleFromUrl(sb.toString(), Integer.valueOf(id),
								i, j);// 查询第i页的评论
					}
				} catch (Exception e) {
					// TODO: handle exception
					System.err.println("**********************获取评论分页错误**********************");
					e.printStackTrace();
				}
			}
		}

	}

	/**
	 * 获取评论内容，调用评论接口主要就是要获取漫画页面的cookies信息，调用时一起传过去；
	 *
	 * @param detailurl 评论的url
	 * @param id        资源id
	 * @param page      评论页数
	 */
	public static void getArticleFromUrl(String detailurl, Integer id,
	                                     Integer page, Integer mainIndex) {
		try {
			long i = System.currentTimeMillis();// 生成时间戳
			Connection connect = Jsoup
					.connect("http://ac.qq.com/Community/topicList?targetId="
							+ id + "&page=" + page + "&_=" + i);
			Map<String, String> header = new HashMap<String, String>();
			header.put("User-Agent",
					"Mozilla/5.0 (Windows NT 10.0; WOW64; rv:55.0) Gecko/20100101 Firefox/55.0");
			header.put(
					"Referer",
					"http://ac.qq.com/Comic/ComicInfo/id/530132?trace_id=1_907_10.194.156.134_1504854317");
			header.put(
					"Cookie",
					"LW_uid=q19499A3B6c0z0Y4z0k5h18046; pgv_pvid=8070181612; eas_sid=11O4U96326x0V0r4j0I5b2c073; pgv_pvi=623979520"
							+ "; pt2gguin=o0877101804; RK=zfdTLMzqZc; ptcz=264e6df783796823cf379b14e6aef6aa3be6a4e2fb4b6126692ee05c2a0b0c4c"
							+ "; ue_ts=1493600756; ue_uk=a058f8c6bbbe035c75bece7707297348; ue_uid=e5fb4837d184233402086deba8d197aa;"
							+ " ue_skey=0e157906ef4cb8f560768be75c751a72; LW_pid=7813c0ffd4b168e438f4a5a82ad1c993; ts_uid=2015751548"
							+ "; ts_refer=www.baidu.com/link; theme=white; roastState=2; readRecord=%5B%5B505430%2C%22%E8%88%AA%E6%B5"
							+ "%B7%E7%8E%8B%22%2C888%2C%22%E7%AC%AC871%E8%AF%9D%20%E5%8A%A0%E6%B2%B9%E5%95%8A%EF%BC%81%E5%87%AF%E6%92"
							+ "%92%EF%BC%81%EF%BC%81%22%2C871%5D%5D; readLastRecord=%5B%5D; pgv_si=s8053975040; pgv_info=ssid=s26281936"
							+ "; ts_last=ac.qq.com/Comic/ComicInfo/id/530132; girlHideState=1; topicPop=1; pc_userinfo_cookie=; o_cookie"
							+ "=877101804");
			Connection data = connect.headers(header);
			Document document = data.get();
			Elements elements = document.getElementsByAttributeValue("class",
					"comment-content-detail");
			List<String> commList = new ArrayList<String>();
			for (Element element : elements) {
				commList.add(element.text());
			}

            /*JSONArray json = new JSONArray();
            for (int j = 0; j < commList.size(); j++) {
                JSONObject jo = new JSONObject();
                jo.put("comment", commList.get(j));
                json.add(jo);
            }
            String comment = json.toString();*/
			String comment = listToString(commList, '\r');
			String date = getLongDate(new Date());
			String indexString = formatCode(mainIndex.toString());
			saveArticle(date + indexString, comment);

		} catch (IOException e) {
			System.err.println("**********************获取评论错误**********************");
			e.printStackTrace();
		}

	}

	private static String formatCode(String code) {
		StringBuilder sb = new StringBuilder();
		int a = 4 - code.length();
		if (a < 0) {
			throw new RuntimeException("formatCode错误 code超过9999");
		}
		for (int i = 0; i < a; i++) {
			sb.append("0");
		}
		sb.append(code);
		return sb.toString();
	}

	/**
	 * 保存内容到本地
	 *
	 * @param titile
	 * @param content
	 */
	public static void saveArticle(String titile, String content) {
		String filePath = "d:\\MyLoadArticle\\" + titile + ".txt";// 保存到本地的路径和文件名
		File file = new File(filePath);
		if (!file.getParentFile().exists()) {
			file.getParentFile().mkdirs();
		}
		try {
			file.createNewFile();
		} catch (IOException e) {
			System.err.println("*******************读取文件错误*******************");
			e.printStackTrace();

		}
		try {
			FileWriter fw = new FileWriter(file, true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(content);
			bw.flush();
			bw.close();
			fw.close();
		} catch (IOException e) {
			System.err.println("*******************写入文件错误*******************");
			e.printStackTrace();
		}

	}

	//时间转换类

	/**
	 * 将Date日期转换成String长类型的yyyyMMddHHmmss
	 *
	 * @param date
	 * @return
	 * @author: Simon
	 * @date: 2017年9月9日 上午9:40:39
	 */
	public static String getLongDate(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String ret = sdf.format(date);
		return ret;
	}
//list根据给定的字符进行切割成String类型

	/**
	 * list转string
	 *
	 * @param list
	 * @param separator
	 * @return
	 * @author: Simon
	 * @date: 2017年9月9日 上午10:24:52
	 */
	public static String listToString(List list, char separator) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < list.size(); i++) {
			if (i == list.size() - 1) {
				sb.append(list.get(i));
			} else {
				sb.append(list.get(i));
				sb.append(separator);
			}
		}
		return sb.toString();
	}
}
