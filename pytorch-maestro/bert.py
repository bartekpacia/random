import torch
from transformers import BertTokenizer, VisualBertModel
from torchvision import models, transforms
from PIL import Image

image_path = "pizza.jpg"

def get_visual_embeddings(image_path):
    # Load a pre-trained ResNet model
    resnet = models.resnet50(pretrained=True)
    resnet = resnet.eval()  # Set to evaluation mode

    # Define image transformations: resize, center crop, normalize, and convert to tensor
    preprocess = transforms.Compose([
        transforms.Resize(256),
        transforms.CenterCrop(224),
        transforms.ToTensor(),
        transforms.Normalize(mean=[0.485, 0.456, 0.406], std=[0.229, 0.224, 0.225]),
    ])

    # Load and preprocess the image
    image = Image.open(image_path).convert("RGB")
    image = preprocess(image)
    image = image.unsqueeze(0)  # Add batch dimension

    # Get the visual embeddings from the ResNet model
    with torch.no_grad():
        visual_embeds = resnet(image)

    # Optionally, reduce dimensionality or modify as needed to fit VisualBERT's input expectations
    visual_embeds = visual_embeds.unsqueeze(1)  # Add sequence length dimension
    return visual_embeds

model = VisualBertModel.from_pretrained("uclanlp/visualbert-vqa-coco-pre")
tokenizer = BertTokenizer.from_pretrained("google-bert/bert-base-uncased")

inputs = tokenizer("What is the man eating?", return_tensors="pt")
# this is a custom function that returns the visual embeddings given the image path
# visual_embeds = get_visual_embeddings(image_path)
visual_embeds = torch.tensor([1.0, 2.0, 3.0, 4.0, 5.0], dtype=torch.float64)

visual_token_type_ids = torch.ones(visual_embeds.shape[:-1], dtype=torch.long)
visual_attention_mask = torch.ones(visual_embeds.shape[:-1], dtype=torch.float)
inputs.update(
    {
        "visual_embeds": visual_embeds,
        "visual_token_type_ids": visual_token_type_ids,
        "visual_attention_mask": visual_attention_mask,
    }
)
outputs = model(**inputs)
last_hidden_state = outputs.last_hidden_state
