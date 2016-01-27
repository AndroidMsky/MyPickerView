package com.msky.mypickerview;

import android.R.integer;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;



@TargetApi(Build.VERSION_CODES.HONEYCOMB) @SuppressLint("NewApi") public class MyAdapter extends BaseAdapter {

    private LayoutInflater mLayoutInflater;
    // 映射数据
    private List<ItemBean> mDataList;
 
    public final int CHANGETIME=200;
 
    Context context;
    public MyAdapter(Context context, List<ItemBean> list) {
        mLayoutInflater = LayoutInflater.from(context);
  
        mDataList = list;
        this.context=context;
    }

    // 获取数据量
    @Override
    public int getCount() {
       
    	return mDataList.size();
    }

    // 获取对应ID项对应的Item
    @Override
    public Object getItem(int position) {
      
    	return mDataList.get(position);
    }

    // 获取对应项ID
    @Override
    public long getItemId(int position) {
      
    	return position;
    }
//
    @TargetApi(Build.VERSION_CODES.HONEYCOMB) @SuppressLint("NewApi") @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        
        ViewHolder holder = null;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = mLayoutInflater.inflate(R.layout.list_item, null);
            holder.numtextview=(TextView) convertView.findViewById(R.id.text);
            
            
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        ItemBean bean = mDataList.get(position);
      /*
       * -10 -1 0 1  2 为五个item的五种状态。
       * 
       * */
        
        
        if (bean.size==-10) {
      	   
        	ObjectAnimator a2=ObjectAnimator.ofFloat( holder.numtextview, "scaleX", b(1.2F),b(1F));
       		a2.setDuration(CHANGETIME);
       	
       		a2.start();
       		ObjectAnimator a22=ObjectAnimator.ofFloat( holder.numtextview, "scaleY", b(1.2F),b(1F));
       		a22.setDuration(CHANGETIME);
       		
       		a22.start();
       		ObjectAnimator a33=ObjectAnimator.ofFloat( holder.numtextview, "RotationX", 0,-30);
       		a33.setDuration(CHANGETIME);
       		
       		a33.start();   
       		ObjectAnimator.ofFloat(holder.numtextview, "Alpha", 0.4F,0.6F).setDuration(CHANGETIME).start();
    		
       		
        	   holder.numtextview.setText(bean.num);
        
            
            
            }
       
        if (bean.size==-1) {
     	   
        	ObjectAnimator a2=ObjectAnimator.ofFloat( holder.numtextview, "scaleX",b(1.2F),b(1F));
       		a2.setDuration(CHANGETIME);
       		a2.start();
       		ObjectAnimator a22=ObjectAnimator.ofFloat( holder.numtextview, "scaleY", b(1.2F),b(1F));
       		a22.setDuration(CHANGETIME);
       	
       		a22.start();
       		ObjectAnimator a33=ObjectAnimator.ofFloat( holder.numtextview, "RotationX", 0,30);
       		a33.setDuration(CHANGETIME);
       		
       		a33.start();   
       		ObjectAnimator.ofFloat(holder.numtextview, "Alpha", 0.4F,0.6F).setDuration(CHANGETIME).start();
    		
        	   holder.numtextview.setText(bean.num);
        	
            
            
            }
        
        
   
       if (bean.size==0) {
    	   
    	ObjectAnimator a2=ObjectAnimator.ofFloat( holder.numtextview, "scaleX", b(1.5F),b(1F));
   		a2.setDuration(CHANGETIME);
   		
   		a2.start();
   		ObjectAnimator a22=ObjectAnimator.ofFloat( holder.numtextview, "scaleY", b(1.5F),b(1F));
   		a22.setDuration(CHANGETIME);
   	
   		a22.start();
   		ObjectAnimator a33=ObjectAnimator.ofFloat( holder.numtextview, "RotationX", 60,0);
   		a33.setDuration(CHANGETIME);

   		a33.start();    
   	  ObjectAnimator.ofFloat(holder.numtextview, "Alpha", 0.3F,0.6F).setDuration(CHANGETIME).start();
   		
   		
    	   holder.numtextview.setText(bean.num);
    	
        
       
    	   if (position==MainActivity.top+2) {
    		   ObjectAnimator.ofFloat(holder.numtextview, "scaleY",  b(15F),b(10F)).setDuration(CHANGETIME/5).start();
    	   		
		}
    	   
    	   
    	   
    	   
    	   
    	   
    	   
    	   
        }
       //  2 4
       if (bean.size==1){
    	   ObjectAnimator a2=ObjectAnimator.ofFloat( holder.numtextview, "scaleX", b(1F),b(1.2F));
   		a2.setDuration(CHANGETIME);
   	
   		a2.start();
   		ObjectAnimator a22=ObjectAnimator.ofFloat( holder.numtextview, "scaleY", b(1F),b(1.2F));
   		a22.setDuration(CHANGETIME);
   	
   		a22.start();	
   		ObjectAnimator a33=ObjectAnimator.ofFloat( holder.numtextview, "RotationX", 60,0);
   		a33.setDuration(CHANGETIME);
   		
   		a33.start();  	
   	 ObjectAnimator.ofFloat(holder.numtextview, "Alpha", 0.6F,0.8F).setDuration(CHANGETIME).start();
		
        holder.numtextview.setText(bean.num);
   

        	
        }
     
       if (bean.size==2){
       	
    		ObjectAnimator a2=ObjectAnimator.ofFloat( holder.numtextview, "scaleX", b(1F),b(1.8F));
    		a2.setDuration(CHANGETIME+100);
    
    		a2.start();
    		ObjectAnimator a22=ObjectAnimator.ofFloat( holder.numtextview, "scaleY", b(1F),b(1.8F));
    		a22.setDuration(CHANGETIME+100);
    
    		a22.start();
    		ObjectAnimator a33=ObjectAnimator.ofFloat( holder.numtextview, "RotationX", 30,0);
       		a33.setDuration(CHANGETIME);
       	
       		a33.start(); 
       		ObjectAnimator.ofFloat(holder.numtextview, "Alpha", 0.8F,1F).setDuration(CHANGETIME).start();
    		
       	  holder.numtextview.setText(bean.num);
       		
      

           	
           }
        return convertView;
     
    }
private float b(float a) {

return a/1.8f;
}
    // ViewHolder用于缓存控件
    class ViewHolder{
        public TextView numtextview;
  
        
    }
}
