package com.neuyuandaima.learnandroid.fragment;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.neuyuandaima.learnandroid.R;
import com.neuyuandaima.learnandroid.bean.News;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

/**
 * Created by neuyuandaima on 2015/8/27.
 */
public class MeFragment extends Fragment{
	private View rootView;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		if (rootView==null){
			new HttpRequestTask().execute();
			rootView=inflater.inflate(R.layout.fragment_viewpage_me,null);
		}
		ViewGroup parent=(ViewGroup)rootView.getParent();
		if (parent!=null){
			parent.removeView(rootView);
		}
		return  rootView;
	}
	private class HttpRequestTask extends AsyncTask<Void, Void, News> {
		@Override
		protected News doInBackground(Void... params) {
			try {
				final String url = "http://10.75.6.40:8080/hello";
				RestTemplate restTemplate = new RestTemplate();
				restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
				News news = restTemplate.getForObject(url, News.class);
				return news;
			} catch (Exception e) {
				Log.e("MainActivity", e.getMessage(), e);
			}
			return null;
		}

		@Override
		protected void onPostExecute(News news) {
			TextView content = (TextView) getActivity().findViewById(R.id.content);
			TextView author = (TextView) getActivity().findViewById(R.id.author);
			TextView type = (TextView) getActivity().findViewById(R.id.type);
			TextView title = (TextView) getActivity().findViewById(R.id.titile);
			String dd=news.getContent();
			content.setText(news.getContent());
			author.setText(news.getAuthor());
			type.setText(news.getNewsType());
			title.setText(news.getTitle());
		}
	}
}
