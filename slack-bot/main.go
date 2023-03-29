package main

import (
	"fmt"
	"os"
	"github.com/slack-go/slack"
)

func main() {
	os.Setenv("SLACK_BOT_TOKEN","")
	os.Setenv("CHANNEL_ID","")
	api := slack.New(os.Getenv("SLACK_BOT_TOKEN"))
	channels := []string{os.Getenv("CHANNEL_ID")}
	files := []string{"readMe.md"}
	for i:=0;i<len(files);i++{
		params := slack.FileUploadParameters{
			Channels : channels,
			File : files[i],
		}
		file, err := api.UploadFile(params)
		if err!=nil{
			fmt.Printf("Error : %s \n",err)
			return
		}
		fmt.Printf("Successfully uploaded %s file URL: %s \n",file.Name, file.URL)
	}

}