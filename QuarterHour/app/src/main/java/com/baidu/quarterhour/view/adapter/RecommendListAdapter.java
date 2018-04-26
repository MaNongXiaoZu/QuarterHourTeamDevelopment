package com.baidu.quarterhour.view.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.baidu.quarterhour.R;
import com.baidu.quarterhour.view.bean.RecommendListSuperClass;
import com.facebook.drawee.view.SimpleDraweeView;

import java.net.URI;
import java.util.List;

/**
 * 推荐里列表适配器
 */

public class RecommendListAdapter extends RecyclerView.Adapter<RecommendListAdapter.ViewHolder> {
    private Context context;
    private List<RecommendListSuperClass.DataBean> list;

    public RecommendListAdapter(Context context) {
        this.context = context;
    }

    public void setList(List<RecommendListSuperClass.DataBean> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @Override
    public RecommendListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recommend_list_layout, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecommendListAdapter.ViewHolder holder, int position) {
        Uri uri = Uri.parse(list.get(position).getUser().getIcon());
        holder.recommend_list_image.setImageURI(uri);

        String nickname = list.get(position).getUser().getNickname();
        if (nickname != null && !"".equals(nickname)){
            holder.recommend_list_name.setText(nickname);
        }
        holder.recommend_list_time.setText(list.get(position).getCreateTime());

        List<RecommendListSuperClass.DataBean.CommentsBean> comments = list.get(position).getComments();
        if (comments.size() != 0){
            holder.recommend_list_content.setText(comments.get(0).getContent());
        }


    }

    @Override
    public int getItemCount() {
        return list != null ? list.size() : 0;
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private SimpleDraweeView recommend_list_image,recommend_list_add;
        private TextView recommend_list_name,recommend_list_time,recommend_list_content;
        private RecyclerView recommend_list_recycleView;

        public ViewHolder(View itemView) {
            super(itemView);
            recommend_list_image = itemView.findViewById(R.id.recommend_list_image);
            recommend_list_name = itemView.findViewById(R.id.recommend_list_name);
            recommend_list_time = itemView.findViewById(R.id.recommend_list_time);
            recommend_list_content = itemView.findViewById(R.id.recommend_list_content);
            recommend_list_add = itemView.findViewById(R.id.recommend_list_add);
            recommend_list_recycleView = itemView.findViewById(R.id.recommend_list_recycleView);
        }
    }
}
